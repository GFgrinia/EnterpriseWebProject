package com.academy.service.impl;

import com.academy.constant.CarStatuses;
import com.academy.constant.MessageManager;
import com.academy.constant.PaymentStatuses;
import com.academy.constant.RequestStatuses;
import com.academy.constant.UserRole;
import com.academy.model.Car;
import com.academy.model.CarStatus;
import com.academy.model.Payment;
import com.academy.model.PaymentStatus;
import com.academy.model.Request;
import com.academy.model.RequestStatus;
import com.academy.model.User;
import com.academy.repository.RequestRepository;
import com.academy.service.interfaces.CarService;
import com.academy.service.interfaces.CarStatusService;
import com.academy.service.interfaces.PaymentService;
import com.academy.service.interfaces.PaymentStatusService;
import com.academy.service.interfaces.RequestService;
import com.academy.service.interfaces.RequestStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;
    private final PaymentService paymentService;
    private final CarService carService;

    private final RequestStatusService requestStatusService;
    private final PaymentStatusService paymentStatusService;
    private final CarStatusService carStatusService;


    @Override
    public List<Request> getRequests(String status, User user) {

        if (user != null) {

            String currentUserRoleName = user.getUserRole().getRoleName();

            if (currentUserRoleName.equals(UserRole.ROLE_ADMIN.roleName)) {
                return status != null ? requestRepository.findRequestByStatus(status) : requestRepository.findAll();
            }

            if (currentUserRoleName.equals(UserRole.ROLE_USER.roleName)) {
                if (status != null) {
                    return requestRepository.findRequestByUserAndRequestStatus(user.getId(), status);
                } else {
                    return requestRepository.findRequestByUser(user.getId());
                }
            }
        }

        return null;
    }


    @Override
    public Request getRequestById(Integer id) {
        return requestRepository.findById(id).orElseThrow();
    }


    @Override
    public List<Request> getRequestByUser(Integer id) {
        return requestRepository.findRequestByUser(id);
    }

    @Override
    @Transactional
    public void saveRequest(Request request) {
        Car car = request.getCar();
        CarStatus carStatus = carStatusService.findByStatus(CarStatuses.RESERVED.label);
        car.setCarStatus(carStatus);

        RequestStatus requestStatus = requestStatusService.findByStatus(RequestStatuses.APPROVAL.label);
        request.setRequestStatus(requestStatus);

        carService.saveCar(car);
        requestRepository.save(request);

    }

    @Override
    @Transactional
    public void changeRequest(Integer id, String status) {

        Request request = requestRepository.findById(id).orElseThrow();
        Car car = request.getCar();
        CarStatus carStatus = new CarStatus();

        RequestStatus requestStatus = requestStatusService.findByStatus(status);


        if (status.equals(RequestStatuses.CANCELED.label)) {
            carStatus = carStatusService.findByStatus(CarStatuses.FREE.label);
        }


        if (status.equals(RequestStatuses.REJECTED.label)) {
            carStatus = carStatusService.findByStatus(CarStatuses.FREE.label);
            request.setComment(MessageManager.REJECT_REASON.label);
        }


        if (status.equals(RequestStatuses.PAYMENT.label)) {
            carStatus = carStatusService.findByStatus(CarStatuses.RESERVED.label);

            Payment payment = new Payment();
            PaymentStatus paymentStatus = paymentStatusService.findByStatus(PaymentStatuses.WAIT.label);
            payment.setPaymentStatus(paymentStatus);
            payment.setRequest(request);
            payment.setAmount(request.getRentDuration() * request.getCar().getRent());
            paymentService.savePayment(payment);
        }


        if (status.equals(RequestStatuses.ACTIVE.label)) {
            carStatus = carStatusService.findByStatus(CarStatuses.INUSE.label);

            Payment payment = paymentService.getPaymentByRequest(request);
            PaymentStatus paymentStatus = paymentStatusService.findByStatus(PaymentStatuses.COMPLETED.label);
            payment.setPaymentStatus(paymentStatus);
            paymentService.savePayment(payment);
        }


        if (status.equals(RequestStatuses.COMPLETED.label)) {
            carStatus = carStatusService.findByStatus(CarStatuses.FREE.label);
        }


        if (status.equals(RequestStatuses.DAMAGED.label)) {
            carStatus = carStatusService.findByStatus(CarStatuses.REPAIR.label);

            Payment payment = new Payment();
            PaymentStatus paymentStatus = paymentStatusService.findByStatus(PaymentStatuses.WAIT.label);
            payment.setPaymentStatus(paymentStatus);
            payment.setRequest(request);
            payment.setAmount((int) (Math.random() * 100) * request.getCar().getRent());
            paymentService.savePayment(payment);
        }


        car.setCarStatus(carStatus);
        request.setCar(car);
        carService.saveCar(car);

        request.setRequestStatus(requestStatus);
        requestRepository.save(request);
    }


}
