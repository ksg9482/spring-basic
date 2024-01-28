package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 클래스 영역에 생성하고 final로 재생성을 막음.
    // 자바가 생성되며 딱 1번 생성해 자기 자신을 가진다.
    private static final SingletonService instance = new SingletonService();

    //인스턴스 반환. 항상 같은 인스턴스를 반환한다.
    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private로 숨김
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
