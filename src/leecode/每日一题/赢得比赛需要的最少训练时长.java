package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/13/14:59
 * @Description:
 */
public class 赢得比赛需要的最少训练时长 {
    public static void main(String[] args) {
        int initialEnergy = 1;
        int initialExperience = 1;
        int[] energy = {1, 1, 1, 1};
        int[] experience = {1, 1, 1, 50};
        int i = minNumberOfHours(initialEnergy, initialExperience, energy, experience);
        System.out.println(i);
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int hours = 0;
        int sum = 0;
        for (int i = 0; i < energy.length; i++) {
            sum += energy[i];
        }
        if (sum >= initialEnergy) {
            hours += (sum - initialEnergy + 1);
            initialEnergy = sum + 1;
        }
        for (int i = 0; i < energy.length; i++) {
            initialEnergy -= energy[i];
            if (initialExperience <= experience[i]) {
                hours += (experience[i] - initialExperience + 1);
                initialExperience += (experience[i] - initialExperience + 1);
            }
            initialExperience += experience[i];
        }
        return hours;
    }
}
