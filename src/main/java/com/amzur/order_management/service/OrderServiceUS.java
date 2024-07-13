package com.amzur.order_management.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.amzur.order_management.dto.request.OrderRequest;
import com.amzur.order_management.dto.response.OrderResponse;
import com.amzur.order_management.entities.LineItemEntity;
import com.amzur.order_management.entities.OrderEntity;
import com.amzur.order_management.repository.LineItemRepository;
import com.amzur.order_management.repository.OrderRepository;


@Profile("us")
@Service
public class OrderServiceUS implements OrderService{
	@Autowired
    private OrderRepository orderRepository;
    @Autowired
    private LineItemRepository lineItemRepository;
	@Override
	public OrderResponse createOrder(OrderRequest orderRequest) {
OrderEntity orderEntity = new OrderEntity();
		
		orderEntity.setUserId(orderRequest.getUserId());
		BeanUtils.copyProperties(orderRequest, orderEntity);
		orderEntity = orderRepository.save(orderEntity);
		final Long orderId = orderEntity.getOrderId();
		orderRequest.getBookIds().stream()
	    .map(bookId -> {
	        LineItemEntity lineItem = new LineItemEntity();
	        lineItem.setOrderId(orderId);
	        lineItem.setBookId(bookId);
	        return lineItem;
	    }).forEach(lineItemRepository::save);
		OrderResponse orderResponse = new OrderResponse();
		//orderResponse.setOrderId(orderId);
		BeanUtils.copyProperties(orderEntity, orderResponse);

		return orderResponse;
	}
	
	

	@Override
	public List<OrderResponse> getOrderById(Long orderId) {
		return lineItemRepository.findByOrderId(orderId).stream().map(this::convertEntitytoResponses).collect(Collectors.toList());
		
	}
		
	@Override
	public List<OrderResponse> getAllOrdersByUserId(Long userId) {

		return orderRepository.findByUserId(userId).stream().map(this::convertEntityToResponse).collect(Collectors.toList());
	}

	public OrderResponse convertEntityToResponse(OrderEntity orderEntity) {
		OrderResponse orderResponse=new OrderResponse();
		BeanUtils.copyProperties(orderEntity, orderResponse);
		return orderResponse;
	}
	public OrderResponse convertEntitytoResponses(LineItemEntity lineItemEntity) {
		OrderResponse orderResponse=new OrderResponse();
		BeanUtils.copyProperties(lineItemEntity, orderResponse);
		return orderResponse;
	}
	public Map<Long, Long> getOrderCountsByUser(LocalDate date) {
		List<OrderEntity>orders=orderRepository.findAllByOrderDate(date);
		return orders.stream().collect(Collectors.groupingBy(OrderEntity::getUserId,Collectors.counting())) ;
	}
	public Long getUserWithMaxOrders(LocalDate date) {
        Map<Long, Long> orderCountsByUser = getOrderCountsByUser(date);
        return orderCountsByUser.entrySet()
                                .stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse(null);
    }

}
