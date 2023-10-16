package com.orderservice.order.Resource;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderservice.order.Entity.Address;
import com.orderservice.order.Entity.Items;
import com.orderservice.order.Entity.Orders;
import com.orderservice.order.Entity.Product;
import com.orderservice.order.Entity.Product1;
import com.orderservice.order.Service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderResource {

    Logger logger= LoggerFactory.getLogger(OrderResource.class);

    @Autowired
    public OrderService orderService;

    @Autowired
    public RestTemplate restTemplate;

    public Date date;

    public OrderResource() {
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Orders>> getAllOrders() {

        try {
            List<Orders> orders = this.orderService.getAllOrders();
            logger.info("Response {}",orders);
            return new ResponseEntity<List<Orders>>(orders, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.info("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<Orders>>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/addOrder/{cartId}")
    private void placeOrder(@PathVariable("cartId") int cartId) {
        Product product = this.restTemplate.getForObject("http://localhost:7002/product/getProductById/" + cartId,
                Product.class);
        int Quantity = 1;
        List<Items> items = new ArrayList<Items>();
        items.add(new Items(product.getProductName(), product.getPrice(), Quantity));
        Address address = this.orderService.getAddressByCustomerId(cartId);
        Product1 product1 = new Product1();
        product1.setProductId(cartId);
        product1.setProductName(product.getProductName());
        Orders order = new Orders();
        order.setProduct(product1);
        order.setAddress(address);
        order.setOrderId(cartId);
        order.setOrderStatus("Order Placed");
        order.setCustomerId(cartId);
        order.setAmountPaid(product.getPrice());
        order.setQuantity(Quantity);
        order.setOrderDate("22-03-2022");
        order.setModeOfPayment("Cash On Delivery");

        this.orderService.placeOrder(order);

    }

    @PutMapping("/updateOrderStatus/{orderStatus}/{orderId}")
    public ResponseEntity<?> changeOrderStatus(@PathVariable("orderStatus") String orderStatus,
            @PathVariable("orderId") int orderId) {

        logger.debug("Request {}",orderStatus);
        try {
            this.orderService.changeStatus(orderStatus, orderId);
            logger.debug("Response {}",HttpStatus.FOUND);
            return new ResponseEntity<>(HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") int orderId)
    {
        logger.debug("Request {}",orderId);
        try {
            this.orderService.deleteOrder(orderId);
            logger.debug("Response {}",HttpStatus.FOUND);
            return new ResponseEntity<String>("Deleted", HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOrderByCustomerId/{customerId}")
    public ResponseEntity<List<Orders>> getOrderByCustomerId(@PathVariable("customerId") int customerId) // done
    {
        logger.debug("Request {}",customerId);
        try {
            List<Orders> orders = this.orderService.getOrderByCustomerId(customerId);
            logger.debug("Response {}",orders);
            return new ResponseEntity<List<Orders>>(orders, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<Orders>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addAddress")
    public void storeAddress(@RequestBody Address address) {

        this.orderService.storeAddress(address);
    }

    @GetMapping("/getAddressByCustomerId/{customerId}")
    public ResponseEntity<Address> getAddressByCustomerId(@PathVariable("customerId") int customerId) // done
    {
        logger.debug("Request {}",customerId);
        try {
            Address address = this.orderService.getAddressByCustomerId(customerId);
            logger.debug("Response {}",address);
            return new ResponseEntity<Address>(address, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllAddress")
    public ResponseEntity<List<Address>> getAllAddress() {

        try {
            List<Address> address = this.orderService.getAllAddress();
            logger.debug("Response {}",address);
            return new ResponseEntity<List<Address>>(address, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<Address>>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deleteAddressByCustomerId/{customerId}")
    public ResponseEntity<?> deleteAddressByCustomerid(@PathVariable("customerId") int customerId) {

        logger.debug("Request {}",customerId);
        try {
            this.orderService.deleteAddressByCustomerId(customerId);
            logger.debug("Response {}",HttpStatus.FOUND);
            return new ResponseEntity<>(HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
