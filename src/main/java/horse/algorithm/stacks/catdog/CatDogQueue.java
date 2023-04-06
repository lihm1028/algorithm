package horse.algorithm.stacks.catdog;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author li.hongming
 * @date 2023/4/6
 */
public class CatDogQueue {
    private Queue<PetEnterQueue> cats=new LinkedList<>();
    private Queue<PetEnterQueue> dogs=new LinkedList<>();
    private long count;



    public void add(Pet pet){
        if (pet.getType().equals("cat")){
            cats.add(new PetEnterQueue(pet,this.count++));
        }
        else if (pet.getType().equals("dog")){
            dogs.add(new PetEnterQueue(pet,this.count++));
        }else {
            throw new IllegalArgumentException("没有类型: "+pet.getType());
        }
    }

    public Pet pollAllCat(){
        if (cats.isEmpty()){
            return null;
        }
            PetEnterQueue poll = cats.poll();
            return poll.getPet();
    }

    public Pet pollAllDog(){
        if (dogs.isEmpty()){
            return null;
        }
        PetEnterQueue poll = dogs.poll();
        return poll.getPet();
    }


    public Pet pollAll(){
        if (!cats.isEmpty() && !dogs.isEmpty()){
            if (cats.peek().getCount()<dogs.peek().getCount()){
                return cats.poll().getPet();
            }else {
                return dogs.poll().getPet();
            }
        }
        if (!cats.isEmpty()){
            return cats.poll().getPet();
        }
        if (!dogs.isEmpty()){
            return dogs.poll().getPet();
        }
        return null;
    }



    public boolean isAllEmpty(){
        return catIsEmpty() && dogIsEmpty();
    }


    public boolean catIsEmpty(){
        return cats.isEmpty();
    }

    public boolean dogIsEmpty(){
        return dogs.isEmpty();
    }

}
