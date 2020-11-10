package com.accenture.javamos.service;

import com.accenture.javamos.controller.exception.UnauthorizedException;
import com.accenture.javamos.entity.Ticket;
import com.accenture.javamos.entity.User;
import com.accenture.javamos.repository.UserRepository;
import com.amadeus.resources.FlightOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

  @Autowired
  SecurityService securityService;

  @Autowired
  UserRepository userRepository;

  /**
   * Create an order to book a flight (this is a reservation)
   * @param order
   * @return A ticket with "pending" status: waiting for payment
   * @throws UnauthorizedException
   */
  public Ticket create(FlightOrder order) throws UnauthorizedException {
    User user = securityService.getUserAuthenticated();
    Ticket ticket = new Ticket(order.getId(), "pending", user);

    user.getTickets().add(ticket);

    userRepository.save(user);

    return ticket;
  }

  public Ticket confirm(Ticket ticket) {
    return ticket;
  }
}
