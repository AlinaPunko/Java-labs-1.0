package by.belstu.it.punko;

import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class WrapperString {
    public String example;
    public void replace(char oldchar, char newchar)
    {
        example.replace(oldchar, newchar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(example, that.example);
    }

    @Override
    public int hashCode() {
        return Objects.hash(example);
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getExample() {
        return example;
    }

    public WrapperString(String example) {
        this.example = example;
    }

}
