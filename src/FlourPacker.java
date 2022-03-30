public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if(bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        if((bigCount * 5 + smallCount) < goal) {
            return false;
        }

        // Below is the optimization used to avoid the suboptimal use of nested for loops
        // (many more loop steps would be required to find a solution compared to below resolution).
        int fullFivesInGoalNumber = goal / 5;
        int factor = (fullFivesInGoalNumber <= bigCount) ? fullFivesInGoalNumber : bigCount;
        return (goal - factor * 5) <= smallCount ? true : false;


    }

    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4));
        System.out.println(canPack(1, 0, 5));
        System.out.println(canPack(0, 5, 4));
        System.out.println(canPack(2, 1, 5));
        System.out.println(canPack(-3, 2, 12));
    }
}
