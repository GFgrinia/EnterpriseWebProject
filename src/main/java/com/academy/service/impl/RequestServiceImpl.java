package com.academy.service.impl;

import com.academy.constant.CarStatuses;
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
import com.academy.repository.CarRepository;
import com.academy.repository.PaymentRepository;
import com.academy.repository.RequestRepository;
import com.academy.service.interfaces.CarStatusService;
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
    private final PaymentRepository paymentRepository;
    private final CarRepository carRepository;

    private final RequestStatusService requestStatusService;
    private final PaymentStatusService paymentStatusService;
    private final CarStatusService carStatusService;


    @Override
    public List<Request> getRequests(String status, User user) {
        String currentUserRoleName = user.getUserRole().getRoleName();

        if (currentUserRoleName.equals(UserRole.ROLE_ADMIN.roleName)) {
            if (status != null) {
                return requestRepository.findRequestByStatus(status);
            } else {
                return requestRepository.findAll();
            }
        }

        if (currentUserRoleName.equals(UserRole.ROLE_USER.roleName)) {
            if (status != null) {
                return requestRepository.findRequestByUserAndRequestStatus(user.getId(),status);
            } else {
                return requestRepository.findRequestByUser(user.getId());
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
    public void providePayment(Integer id) {
        Request request = requestRepository.findById(id).orElseThrow();
        RequestStatus requestStatus = requestStatusService.findByStatus(RequestStatuses.ACTIVE.label);
        request.setRequestStatus(requestStatus);

        Payment payment = new Payment();
        PaymentStatus paymentStatus = paymentStatusService.findByStatus(PaymentStatuses.COMPLETED.label);
        payment.setPaymentStatus(paymentStatus);
        payment.setRequest(request);

        requestRepository.save(request);
        paymentRepository.save(payment);
    }


    @Override
    @Transactional
    public void provideReturn(Integer id) {
        Request request = requestRepository.findById(id).orElseThrow();
        RequestStatus requestStatus = requestStatusService.findByStatus(RequestStatuses.COMPLETED.label);
        request.setRequestStatus(requestStatus);


        boolean repair = checkCarState();
        String status = repair ? CarStatuses.REPAIR.label : CarStatuses.FREE.label;

        CarStatus carStatus = carStatusService.findByStatus(status);
        Car car = request.getCar();
        car.setCarStatus(carStatus);


        requestRepository.save(request);
        carRepository.save(car);
        if (true) {
            Payment payment = new Payment();
            PaymentStatus paymentStatus = paymentStatusService.findByStatus(PaymentStatuses.WAIT.label);
            payment.setPaymentStatus(paymentStatus);
            payment.setRequest(request);
            paymentRepository.save(payment);
        }

    }


    private boolean checkCarState() {
        int carState = (int) (Math.random() * 100);
        return carState > 50;
    }
}
