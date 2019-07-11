import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Havel_Hakimi {

    private boolean performHavelHakimi(List<Integer> sequence) {
        sequence = sequence.stream().filter(c -> c != 0).collect(Collectors.toList());
        if (sequence.size() == 0) {
            return true;
        }
        sequence = sequence.stream().sorted((n1, n2) -> Integer.compare(n2, n1)).collect(Collectors.toList());
        Integer x = sequence.remove(0);
        if (x > sequence.size()) {
            return false;
        }
        for (int i = 0; i < x; i++) {
            sequence.set(i, sequence.get(i) - 1);
        }
        return (performHavelHakimi(sequence));


    }

    public static void main(String[] args) {
        Havel_Hakimi hh = new Havel_Hakimi();
        System.out.println(hh.performHavelHakimi(Arrays.asList(5, 3, 0, 2, 6, 2, 0, 7, 2, 5)));
        System.out.println(hh.performHavelHakimi(Arrays.asList(3, 1, 2, 3, 1, 0)));
        System.out.println(hh.performHavelHakimi(Arrays.asList(16, 9, 9, 15, 9, 7, 9, 11, 17, 11, 4, 9, 12, 14, 14, 12, 17, 0, 3, 16)));
        System.out.println(hh.performHavelHakimi(Arrays.asList(14, 10, 17, 13, 4, 8, 6, 7, 13, 13, 17, 18, 8, 17, 2, 14, 6, 4, 7, 12)));
        System.out.println(hh.performHavelHakimi(Arrays.asList(15, 18, 6, 13, 12, 4, 4, 14, 1, 6, 18, 2, 6, 16, 0, 9, 10, 7, 12, 3)));


    }
}
