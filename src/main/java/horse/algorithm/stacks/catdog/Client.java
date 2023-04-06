package horse.algorithm.stacks.catdog;

/**
 * @author li.hongming
 * @date 2023/4/6
 */
public class Client {

    public static void main(String[] args) {
        CatDogQueue catDogQueue = new CatDogQueue();

        // 添加1猫1狗
        catDogQueue.add(new Cat());
        catDogQueue.add(new Dog());
        catDogQueue.add(new Cat());
        catDogQueue.add(new Dog());
        catDogQueue.add(new Cat());
        catDogQueue.add(new Dog());


        while (!catDogQueue.isAllEmpty()){
            System.out.println(catDogQueue.pollAll().getType());
        }


//        while (!catDogQueue.catIsEmpty()){
//            System.out.println(catDogQueue.pollAllCat().getType());
//        }
//
//        while (!catDogQueue.dogIsEmpty()){
//            System.out.println(catDogQueue.pollAllDog().getType());
//        }


    }


}
