package com.od.order.Resource;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.orderservice.order.Entity.Address;
import com.orderservice.order.Entity.Orders;
import com.orderservice.order.Entity.Product1;
import com.orderservice.order.Resource.OrderResource;
import com.orderservice.order.Service.OrderService;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { OrderResourceTest.class })
public class OrderResourceTest {

    @Mock
    public OrderService orderService;

    @InjectMocks
    public OrderResource orderResource;

    @Test
    @Order(1)
    void testChangeOrderStatus() {

        String orderStatus = "Order Placed";
        int orderId = 10;

        orderResource.changeOrderStatus(orderStatus, orderId);
        verify(orderService, times(1)).changeStatus(orderStatus, orderId);

    }

    @Test
    @Order(2)
    void testDeleteAddressByCustomerid() {

        int customerId = 10;
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setFullName("Shashank Pandey");
        address.setMobileNumber("9654368445");
        address.setFlatNumber(101);
        address.setCity("Champa");
        address.setPincode(495671);
        address.setState("Chhattisgarh");

        orderResource.deleteAddressByCustomerid(customerId);
        verify(orderService, times(1)).deleteAddressByCustomerId(customerId);

    }

    @Test
    @Order(3)
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

        orderService.deleteOrder(order.getOrderId());
        ResponseEntity<String> responseEntity = orderResource.deleteOrder(order.getOrderId());
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(4)
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

        when(this.orderService.getAddressByCustomerId(customerId)).thenReturn(address);
        ResponseEntity<Address> responseEntity = orderResource.getAddressByCustomerId(customerId);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
    }

    @Test
    @Order(5)
    void testGetAllAddress() {

        int customerId = 10;
        List<Address> address = new ArrayList<Address>();
        address.add(new Address(customerId, "Shashank Pandey", "9654368445", 101, "Champa", 495671, "Chhattisgarh"));

        when(this.orderService.getAllAddress()).thenReturn(address);
        ResponseEntity<List<Address>> responseEntity = orderResource.getAllAddress();
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(6)
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

        when(this.orderService.getAllOrders()).thenReturn(order);
        ResponseEntity<List<Orders>> responseEntity = orderResource.getAllOrders();
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(7)
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

        when(this.orderService.getOrderByCustomerId(customerId)).thenReturn(order);
        ResponseEntity<List<Orders>> responseEntity = orderResource.getOrderByCustomerId(customerId);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(8)
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

        orderResource.storeAddress(address);
        verify(orderService, times(1)).storeAddress(address);

    }
}
