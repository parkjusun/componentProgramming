package polymorphism;public class LgTV implements TV {    public LgTV(){        System.out.println("===> LgTV 객체생성");    }    @Override    public void powerOn() {        System.out.println("LgTV -------- 전원 킨다. ");    }    @Override    public void powerOff() {        System.out.println("LgTV -------- 전원 끊다. ");    }    @Override    public void volumeUp() {        System.out.println("LgTV -------- 소리를 올리다. ");    }    @Override    public void volumeDown() {        System.out.println("LgTV -------- 소리를 내린다. ");    }}