package com.onlineShopping.Shophub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.onlineShopping.Shophub.entity.Categories;
import com.onlineShopping.Shophub.entity.Customer;
import com.onlineShopping.Shophub.entity.Discount;
import com.onlineShopping.Shophub.entity.GiftCards;
import com.onlineShopping.Shophub.entity.Orders;
import com.onlineShopping.Shophub.entity.Payments;
import com.onlineShopping.Shophub.entity.Products;
import com.onlineShopping.Shophub.entity.Refund;
import com.onlineShopping.Shophub.entity.Returns;
import com.onlineShopping.Shophub.entity.Reviews;
import com.onlineShopping.Shophub.entity.Shipment;
import com.onlineShopping.Shophub.entity.ShoppingCart;
import com.onlineShopping.Shophub.entity.Users;
import com.onlineShopping.Shophub.entity.Wishlist;






/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //Create Session
        Configuration conf = new Configuration().configure().addAnnotatedClass(Users.class).addAnnotatedClass(Orders.class).addAnnotatedClass(Reviews.class).addAnnotatedClass(Categories.class).addAnnotatedClass(Products.class).addAnnotatedClass(Payments.class).addAnnotatedClass(Returns.class).addAnnotatedClass(ShoppingCart.class).addAnnotatedClass(GiftCards.class).addAnnotatedClass(Customer.class).addAnnotatedClass(Wishlist.class).addAnnotatedClass(Shipment.class).addAnnotatedClass(Refund.class).addAnnotatedClass(Discount.class);
        SessionFactory ss= conf.buildSessionFactory();
        Session s =ss.openSession();
        Transaction t =s.beginTransaction();
        

        //To get current date
        LocalDate currentDate = LocalDate.now();
        
        //To get future date
        LocalDate expiryDate = currentDate.plusMonths(24);
        
        //Users Object
        Users users1 = new Users("Manish Shah","manish@gmail.com","Manish123","9877797890","Customer",currentDate);
        Users users2 = new Users("Nisha Mishra","nisha@gmail.com","Nisha123","9879827890","Customer",currentDate);
      
        Customer customer1 = new Customer(1,"sp road pune");
        
        //Categories Object
        Categories categories1 = new Categories(2,"Cosmetics");

        //Orders Object1
        Orders orders1 = new Orders();
        orders1.setOrderID(101);
        orders1.setCustomerID(1);
        orders1.setOrderDate(currentDate);
        orders1.setStatus("Order Confirmed");
        orders1.setCustomer(customer1);
       
        //Orders Object2
        Orders orders2 = new Orders();
        orders2.setOrderID(102);
        orders2.setCustomerID(1);
        orders2.setOrderDate(currentDate);
        orders2.setStatus("Shipped");
        orders2.setCustomer(customer1);

         
        
        //Payments Object1
        Payments payments1 = new Payments();
        payments1.setPaymentID(101);
        payments1.setOrderID(101);
        payments1.setAmount(900);
        payments1.setPaymentDate(currentDate);
        payments1.setPaymentMethod("UPI");
        orders1.setPayments(payments1);
        payments1.setOrders(orders1);
        s.persist(orders1);
        s.persist(payments1);
        payments1.setCustomer(customer1);
        
        //Payments Object2
        Payments payments2 = new Payments();
        payments2.setPaymentID(102);
        payments2.setOrderID(102);
        payments2.setAmount(479);
        payments2.setPaymentDate(currentDate);
        payments2.setPaymentMethod("PhonePe");
        orders2.setPayments(payments2);
        payments2.setOrders(orders2);
        s.persist(orders2);
        s.persist(payments2);
        payments2.setCustomer(customer1);


        //ShoppingCart Object1
        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setCartID(101);
        shoppingCart1.setCustomerID(1);
        shoppingCart1.setProductID(101);
        shoppingCart1.setQuantity(2);
        shoppingCart1.setCustomer(customer1);
        customer1.setShoppingCart(shoppingCart1);
        s.persist(shoppingCart1);
        s.persist(customer1);
        
        
        
        //Returns Object
        Returns returns1 = new Returns();
        returns1.setReturnID(1);
        returns1.setOrderID(101);
        returns1.setReturnDate(currentDate);
        returns1.setReason("not exact product");
        returns1.setStatus("Pending");
        returns1.setOrders(orders1);
        orders1.setReturns(returns1);
        s.persist(orders1);
        s.persist(returns1);
        returns1.setCustomer(customer1);
        
        
        Returns returns2 = new Returns();
        returns2.setReturnID(2);
        returns2.setOrderID(102);
        returns2.setReturnDate(currentDate);
        returns2.setReason("not exact product");
        returns2.setStatus("Confirmed");
        returns2.setOrders(orders2);
        orders2.setReturns(returns2);
        s.persist(orders2);
        s.persist(returns2);
        returns2.setCustomer(customer1);
        
        
        Wishlist wishlist1 = new Wishlist();
        wishlist1.setWishlistID(5);
        wishlist1.setCustomerID(1);
        wishlist1.setProductID(101);
        wishlist1.setDateAdded(currentDate);
        wishlist1.setCustomer(customer1);
        customer1.setWishlist(wishlist1);
        s.persist(wishlist1);
        s.persist(customer1);
           
        Discount discount1 =new Discount();
        discount1.setDiscountID(1);
        discount1.setDiscountName("Bumper offer");
        discount1.setDiscountPercent(30);
  
        //Product Object1
        Products products1 = new Products();
        products1.setProductID(101);
        products1.setProductName("perfume");
        products1.setCategoryID(2);
        products1.setPrice(500);
        products1.setStockQuantity(200);
        products1.setDescription("The world of luxury perfumes, one mini at a time!");
        products1.setCategories(categories1);
        products1.setShoppingCart(shoppingCart1);
        products1.setDiscount(discount1);
        products1.setWishlist(wishlist1);
        
        
        
        //Product Object2
        Products products2 = new Products();
        products2.setProductID(102);
        products2.setProductName("Foundation");
        products2.setCategoryID(2);
        products2.setPrice(479);
        products2.setStockQuantity(300);
        products2.setDescription("Achieve a long-lasting, flawless base with Foundation! ");
        products2.setCategories(categories1);
        products2.setShoppingCart(shoppingCart1);
        products2.setDiscount(discount1);
        products2.setWishlist(wishlist1);
        
        //manytomany of product and orders
        orders1.getProducts().add(products1);
        orders1.getProducts().add(products2);
        orders2.getProducts().add(products1);
        orders2.getProducts().add(products2);
        s.persist(orders1);
        s.persist(orders2);
        
        
        
        //Review object1
        Reviews reviews1 = new Reviews();
        reviews1.setReviewID(10);
        reviews1.setCustomerID(1);
        reviews1.setProductID(101);
        reviews1.setRating(4.0);
        reviews1.setComment("Nice Quality");
        reviews1.setReviewDate(currentDate);
        reviews1.setProducts(products1);
        reviews1.setCustomer(customer1);
        
        Reviews reviews2 = new Reviews();
        reviews2.setReviewID(11);
        reviews2.setCustomerID(1);
        reviews2.setProductID(101);
        reviews2.setRating(5.0);
        reviews2.setComment("good product");
        reviews2.setReviewDate(currentDate);
        reviews2.setProducts(products1);
        reviews2.setCustomer(customer1);
        
        //GiftCards Object1
        GiftCards giftCards1 = new GiftCards();
        giftCards1.setGiftCardID(1);
        giftCards1.setCode("CDE3344567");
        giftCards1.setAmount(1000);
        giftCards1.setExpiryDate(expiryDate);
        giftCards1.setCustomerID(1);
        giftCards1.setCustomer(customer1);
        giftCards1.setPayments(payments1);
        
       
        //GiftCards Object1
        GiftCards giftCards2 = new GiftCards();
        giftCards2.setGiftCardID(2);
        giftCards2.setCode("ASD3398767");
        giftCards2.setAmount(5000);
        giftCards2.setExpiryDate(expiryDate);
        giftCards2.setCustomerID(1);
        giftCards2.setCustomer(customer1);
        giftCards2.setPayments(payments1);
        
        
        Shipment shipment1 = new Shipment();
        shipment1.setShipmentID(1);
        shipment1.setShipmentDate(currentDate);
        shipment1.setState("Maharashtra");
        shipment1.setCity("Shegaon");
        shipment1.setPincode("444203");
        shipment1.setHouseName("Kherde House");
        shipment1.setArea("Near Gajanan Maharaj Temple");
        shipment1.setCustomer(customer1);
        shipment1.setOrders(orders1);
        orders1.setShipment(shipment1);
        s.persist(shipment1);
        s.persist(orders1);
        
        
        
        Shipment shipment2 = new Shipment();
        shipment2.setShipmentID(2);
        shipment2.setShipmentDate(currentDate);
        shipment2.setState("Maharashtra");
        shipment2.setCity("Akola");
        shipment2.setPincode("444234");
        shipment2.setHouseName("Birla House");
        shipment2.setArea("Gandhi Cwok");
        shipment2.setCustomer(customer1);
        
        Refund refund1 = new Refund();
        refund1.setRefundID(1);
        refund1.setOrderID(101);
        refund1.setCustomerID(1);
        refund1.setRefundDate(currentDate);
        refund1.setRefundAmount(300);
        refund1.setCustomer(customer1);
        refund1.setOrders(orders1);
        orders1.setRefund(refund1);
        s.persist(refund1);
        s.persist(orders1);
        refund1.setPayments(payments1);
        payments1.setRefund(refund1);
        s.persist(payments1);
        s.persist(refund1);
        
        
        Refund refund2 = new Refund();
        refund2.setRefundID(2);
        refund2.setOrderID(102);
        refund2.setCustomerID(1);
        refund2.setRefundDate(currentDate);
        refund2.setRefundAmount(500);
        refund2.setCustomer(customer1);
  
        
        //Orders List
        List<Orders> list1 = new ArrayList();
        list1.add(orders1);
        list1.add(orders2);
        customer1.setOrders(list1);
        s.persist(customer1);
        
        
        //Product List
        List<Products> list2 = new ArrayList();
        list2.add(products1);
        list2.add(products2);
        categories1.setProducts(list2);
        s.persist(categories1);
        shoppingCart1.setProducts(list2);
        s.persist(shoppingCart1);
        discount1.setProducts(list2);
        s.persist(discount1);
        wishlist1.setProducts(list2);
        s.persist(wishlist1);
        
        //GiftCards List
        List<GiftCards> list3 = new ArrayList();
        list3.add(giftCards1);
        list3.add(giftCards2);
        customer1.setGiftCards(list3);
        s.persist(customer1);
        payments1.setGiftCards(list3);
        s.persist(payments1);
         
        List<Shipment> list5 = new ArrayList();
        list5.add(shipment1);
        list5.add(shipment2);
        customer1.setShipment(list5);
        s.persist(customer1);
      
        List<Payments> list6 = new ArrayList();
        list6.add(payments1);
        list6.add(payments2);
        customer1.setPayments(list6);
        s.persist(customer1);
   
        List<Returns> list7 = new ArrayList();
        list7.add(returns1);
        list7.add(returns2);
        customer1.setReturns(list7);
        s.persist(customer1);
        
        List<Reviews> list8 = new ArrayList();
        list8.add(reviews1);
        list8.add(reviews2);
        customer1.setReviews(list8);
        products1.setReviews(list8);
        s.persist(customer1);
        
        List<Refund> list9 = new ArrayList();
        list9.add(refund1);
        list9.add(refund2);
        customer1.setRefund(list9);;
        s.persist(customer1);
        
        t.commit();
        ss.close();
    }
}
