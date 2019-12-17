package triangle;

public class locatorsList {

    private String htmlTitle = "//title[text()='Calculadora de Triângulos']";
    private String mainTitle = "//h2[text()='Informe os Lados do Triângulo']";
    private String side1Label = "//label[text()='Lado 1:']";
    private String side2Label = "//label[text()='Lado 2:']";
    private String side3Label = "//label[text()='Lado 3:']";
    private String side1Input = "lado1";
    private String side2Input = "lado2";
    private String side3Input = "lado3";
    private String button = "calcular";
    private String classificationMessage = "message";

    public String getHtmlTitle() {
        return htmlTitle;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public String getSide1Label() {
        return side1Label;
    }

    public String getSide2Label() {
        return side2Label;
    }

    public String getSide3Label() {
        return side3Label;
    }

    public String getSide1Input() {
        return side1Input;
    }

    public String getSide2Input() {
        return side2Input;
    }

    public String getSide3Input() {
        return side3Input;
    }

    public String getButton() {
        return button;
    }

    public String getClassificationMessage() {
        return classificationMessage;
    }
}
