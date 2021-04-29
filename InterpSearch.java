import java.util.List;

public class InterpSearch {
    public static int interpolationSearch(List<Integer> integers, int elementToSearch) {

        int startIndex = 0;
        int lastIndex = (integers.size() - 1);

        while ((startIndex <= lastIndex) && (elementToSearch >= integers.get(startIndex)) &&
                (elementToSearch <= integers.get(lastIndex))) {
            // используем формулу интерполяции для поиска возможной лучшей позиции для существующего элемента
            int pos = startIndex + (((lastIndex-startIndex) /
                    (integers.get(lastIndex)-integers.get(startIndex)))*
                    (elementToSearch - integers.get(startIndex)));

            if (integers.get(pos) == elementToSearch)
                return pos;

            if (integers.get(pos) < elementToSearch)
                startIndex = pos + 1;

            else
                lastIndex = pos - 1;
        }
        return -1;
    }

}
