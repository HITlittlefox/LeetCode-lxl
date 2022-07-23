package class01;

public class Body {
    int Size;
    Hand leftHand;
    Hand rightHand;
    Foot leftFoot;
    Foot rightFoot;

    public void move() {
        System.out.println("body is moving");
    }

    public void increase() {
        Size++;
        System.out.println("bodySize=" + Size);
        System.out.println("body is increasing");
    }

    public void letHandsClap() {
        leftHand = new Hand();
        rightHand = new Hand();
        leftHand.clap();
        rightHand.clap();

    }

//    public void letFootRunning() {
//        leftFoot = new Foot();
//        rightFoot = new Foot();
//        leftFoot.move();
//        rightFoot.move();
////        leftFoot.run();
////        rightFoot.run();
//
//
//    }
}

class Foot extends Body {
    int length;

    public void run() {
        System.out.println("foot is running");
    }

    @Override
    public void move() {
        System.out.println("Body is moving and foot is moving");
    }

}
