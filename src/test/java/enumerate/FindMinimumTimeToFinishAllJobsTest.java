package enumerate;

import search.FindMinimumTimeToFinishAllJobs;

public class FindMinimumTimeToFinishAllJobsTest {
    public static void main(String[] args) {
        FindMinimumTimeToFinishAllJobs fm = new FindMinimumTimeToFinishAllJobs();
        System.out.println(fm.minimumTimeRequired(new int[]{6518448,8819833,7991995,7454298,2087579,380625,4031400,2905811,4901241,8480231,7750692,3544254}, 4));
        System.out.println(fm.minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
        System.out.println(fm.minimumTimeRequired(new int[]{5129437,1842905,2200851,597069,8618690,5823974,3199380,2416829,7138804,2445093,7207875,7133141}, 3));
    }
}
