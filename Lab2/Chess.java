public class Chess {
    /**
     * размерность доски
     */
    private int dimension;
    /**
        if (index == 0) {
            return false;
        } else {
            return move(index - 1);
        }
    }

    /*
     * Возврашает порядковый номер комбинации, которая в данный момент
     * установлена.
     */

    /*
     * Распечатывает доску с фигурами, чтобы понять,
     * как генерируются комбинации.
     */
    public void printState() {
        for (int i = 0; i < state.length; i++) {
            int position = state[i];
            for (int j = 0; j < dimension; j++) {
                System.out.print(j == position ? 'X' : '_');
            }
            System.out.println();
        }
    }
}