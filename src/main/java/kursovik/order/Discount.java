//package kursovik.order;
//
//import java.io.IOException;
//
///**
// * Created by Hamster4n.
// */
//public class Discount { //discount by summ
//
//    private double price;    // For price
//    private double dis;     // For Discount
//    private double quantity; // For Quantity
//
//    void discount() {
//        if (price <= 2000)
//            dis = price * 0.05;
//        else if (price > 2000 && price <= 5000)
//            dis = price * 0.25;
//        else if (price > 5000 && price <= 10000)
//            dis = price * 0.35;
//        else
//            dis = price * 0.5;
//        amt = price - dis;
//
//    }
//
//     void discountByQuantity() {
//        if (quantity <= 2)
//            dis = 0;
//            //offer goods (Y/N)
//            //addQuantity()
//        else if (quantity > 2 && quantity <= 5)
//            dis = price * 0.05;
//        else if (quantity > 5 && quantity <= 10)
//            dis = price * 0.1;
//        else
//            dis = price * 0.5;
//        amt = price - dis;
//
//    public static void main(String args[]) throws IOException {
//        Discount ob = new Discount();
//        ob.discount();
//    }
//}
