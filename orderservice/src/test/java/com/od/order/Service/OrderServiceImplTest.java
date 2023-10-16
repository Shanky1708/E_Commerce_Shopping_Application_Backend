package com.od.order.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.orderservice.order.Entity.Address;
import com.orderservice.order.Entity.Orders;
import com.orderservice.order.Entity.Product1;
import com.orderservice.order.Repository.AddressRepository;
import com.orderservice.order.Repository.OrderRepository;
import com.orderservice.order.Service.OrderServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { OrderServiceImplTest.class })
public class OrderServiceImplTest {

    @Mock
    public OrderRepository orderRepository;

    @Mock
    public AddressRepository addressRepository;

    @InjectMocks
    public OrderServiceImpl orderServiceImpl;

    @Test
    @Order(1)
    void testDeleteAddressByCustomerId() {

        int customerId = 10;
        orderServiceImpl.deleteAddressByCustomerId(customerId);
        verify(addressRepository, times(1)).deleteById(customerId);

    }

    @Test
    @Order(2)
    void testDeleteOrder() {

        int customerId = 10;
        int cartId = 10;
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setFullName("Shashank Pandey");
        address.setMobileNumber("9654368445");
        address.setFlatNumber(101);
        address.setCity("Champa");
        address.setPincode(495671);
        address.setState("Chhattisgarh");

        Product1 product1 = new Product1();
        product1.setProductId(customerId);
        product1.setProductName("Garnier Facewash");

        Orders order = new Orders();
        order.setProduct(product1);
        order.setAddress(address);
        order.setOrderId(cartId);
        order.setOrderStatus("Order Placed");
        order.setCustomerId(cartId);
        order.setAmountPaid(135.00);
        order.setQuantity(1);
        order.setOrderDate("22-03-2022");
        order.setModeOfPayment("Cash On Delivery");

        orderServiceImpl.deleteOrder(order.getOrderId());
        verify(orderRepository, times(1)).deleteById(order.getOrderId());
        ;

    }

    @Test
    @Order(3)
    void testGetAddressByCustomerId() {

        int customerId = 10;
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setFullName("Shashank Pandey");
        address.setMobileNumber("9654368445");
        address.setFlatNumber(101);
        address.setCity("Champa");
        address.setPincode(495671);
        address.setState("Chhattisgarh");

        when(this.addressRepository.findByCustomerId(customerId)).thenReturn(address);
        assertEquals(address, orderServiceImpl.getAddressByCustomerId(customerId));

    }

    @Test
    @Order(4)
    void testGetAllAddress() {

        List<Address> address = new ArrayList<Address>();
        address.add(new Address(10, "Shashank Pandey", "9654368445", 101, "Champa", 495671, "Chhattisgarh"));

        when(this.addressRepository.findAll()).thenReturn(address);
        assertEquals(address, orderServiceImpl.getAllAddress());

    }

    @Test
    @Order(5)
    void testGetAllOrders() {

        int customerId = 10;
        int cartId = 10;
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setFullName("Shashank Pandey");
        address.setMobileNumber("9654368445");
        address.setFlatNumber(101);
        address.setCity("Champa");
        address.setPincode(495671);
        address.setState("Chhattisgarh");

        Product1 product1 = new Product1();
        product1.setProductId(customerId);
        product1.setProductName("Garnier Facewash");

        List<Orders> order = new ArrayList<Orders>();
        order.add(new Orders(cartId, "22-03-2022", cartId, 135.00, "Cash-On-Delivery", "Order Placed", 1, address,
                product1));

        when(this.orderRepository.findAll()).thenReturn(order);
        assertEquals(order, orderServiceImpl.getAllOrders());

    }

    @Test
    @Order(6)
    void testGetOrderByCustomerId() {

        int customerId = 10;
        int cartId = 10;
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setFullName("Shashank Pandey");
        address.setMobileNumber("9654368445");
        address.setFlatNumber(101);
        address.setCity("Champa");
        address.setPincode(495671);
        address.setState("Chhattisgarh");

        Product1 product1 = new Product1();
        product1.setProductId(customerId);
        product1.setProductName("Garnier Facewash");

        List<Orders> order = new ArrayList<Orders>();
        order.add(new Orders(cartId, "22-03-2022", cartId, 135.00, "Cash-On-Delivery", "Order Placed", 1, address,
                product1));

        when(this.orderRepository.findByCustomerId(customerId)).thenReturn(order);
        assertEquals(order, orderServiceImpl.getOrderByCustomerId(customerId));

    }

    @Test
    @Order(7)
    void testGetOrderById() {

        int customerId = 10;
        int cartId = 10;
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setFullName("Shashank Pandey");
        address.setMobileNumber("9654368445");
        address.setFlatNumber(101);
        address.setCity("Champa");
        address.setPincode(495671);
        address.setState("Chhattisgarh");

        Product1 product1 = new Product1();
        product1.setProductId(customerId);
        product1.setProductName("Garnier Facewash");

        Orders order = new Orders();
        order.setProduct(product1);
        order.setAddress(address);
        order.setOrderId(cartId);
        order.setOrderStatus("Order Placed");
        order.setCustomerId(cartId);
        order.setAmountPaid(135.00);
        order.setQuantity(1);
        order.setOrderDate("22-03-2022");
        order.setModeOfPayment("Cash On Delivery");

        when(this.orderRepository.findOrderByOrderId(order.getOrderId())).thenReturn(order);
        assertEquals(order, orderServiceImpl.getOrderById(order.getOrderId()));

    }

    @Test
    @Order(8)
    void testPlaceOrder() {

        int customerId = 10;
        int cartId = 10;
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setFullName("Shashank Pandey");
        address.setMobileNumber("9654368445");
        address.setFlatNumber(101);
        address.setCity("Champa");
        address.setPincode(495671);
        address.setState("Chhattisgarh");

        Product1 product1 = new Product1();
        product1.setProductId(customerId);
        product1.setProductName("Garnier Facewash");

        Orders order = new Orders();
        order.setProduct(product1);
        order.setAddress(address);
        order.setOrderId(cartId);
        order.setOrderStatus("Order Placed");
        order.setCustomerId(cartId);
        order.setAmountPaid(135.00);
        order.setQuantity(1);
        order.setOrderDate("22-03-2022");
        order.setModeOfPayment("Cash On Delivery");

        orderServiceImpl.placeOrder(order);
        verify(orderRepository, times(1)).save(order);

    }

    @Test
    @Order(9)
    void testStoreAddress() {

        int customerId = 10;
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setFullName("Shashank Pandey");
        address.setMobileNumber("9654368445");
        address.setFlatNumber(101);
        address.setCity("Champa");
        address.setPincode(495671);
        address.setState("Chhattisgarh");

        orderServiceImpl.storeAddress(address);
        verify(addressRepository, times(1)).save(address);

    }
}
