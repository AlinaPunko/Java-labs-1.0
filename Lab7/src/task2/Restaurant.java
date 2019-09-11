package task2;

public class Restaurant
{
        private int amountOfTables;
        private Client[] tables;

        public Restaurant(int size) {
            this.amountOfTables = size;
            this.tables = new Client[size];
        }

        public void showTables() {
            System.out.println("Tables:{");
            for (int i = 0; i < amountOfTables; i++) {
                if (tables[i] != null) {
                    System.out.println(i + ") " + tables[i].getClientName());
                } else {
                    System.out.println(i + ") empty");
                }
            }
            System.out.println("}");
        }

        public void sit(Client client) {
            tables[this.FreeTable()] = client;
        }

        public void endedeating(Client client) {
            for (int i = 0; i < this.amountOfTables; i++) {
                if (tables[i] == client) {
                    tables[i] = null;
                }
            }
        }

        public int FreeTable() {
            for (int i = 0; i < this.amountOfTables; i++) {
                if (tables[i] == null) {
                    return i;
                }
            }
            return -1;
        }

}
