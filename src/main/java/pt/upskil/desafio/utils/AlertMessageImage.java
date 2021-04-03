package pt.upskil.desafio.utils;

public enum AlertMessageImage {
    // Alert message image
    FAILURE("/imagens/minion-error.png"),
    SUCCESS("/imagens/minion_success.png");

    private final String imageURL;

    AlertMessageImage(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }
}
