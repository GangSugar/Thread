package 观察线程的所有状态;

/**
 * 了解枚举
 */
public class MyEnum {
    enum Gender{
        FEMALE,MALE;
    }

    //Gender gender;

    public static void main(String[] args) {
        Gender[] values = Gender.values();//枚举就是有多少个值，就能够拿到多少个值
        for (Gender gender : values){
            System.out.println(gender);
        }
    }
}
