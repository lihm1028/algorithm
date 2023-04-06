package horse.algorithm.stacks.catdog;

/**
 * @author li.hongming
 * @date 2023/4/6
 */
public class PetEnterQueue {

    private Pet pet;

    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }
}
