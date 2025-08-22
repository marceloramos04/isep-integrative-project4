package utils;

public class WiderDescription {

        private String description;

        public WiderDescription(String description) {

            if (description == null || description.isEmpty()) {
                throw new IllegalArgumentException("Description should neither be null nor empty");
            }

            if (!checkDescriptionWords(description)) {
                throw new IllegalArgumentException("Description should have at most 200 words");
            }



            this.description = description;
        }

        private boolean checkDescriptionWords(String description) {
            int count = 0;
            description = description.trim();
            for (int i = 1; i < description.length(); i++) {
                if (description.charAt(i) == ' ' && description.charAt(i - 1) != ' ') {
                    count ++;
                }
            }

            return count <= 200; // description should have at most 100 words
        }


        @Override
        public String toString() {
            return description;
        }
}
