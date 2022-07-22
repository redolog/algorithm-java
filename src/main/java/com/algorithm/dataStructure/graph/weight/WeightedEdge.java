package com.algorithm.dataStructure.graph.weight;

/**
 * 权重边
 *
 * @author dragonsong  @date 2022/6/17
 */
public class WeightedEdge<Weight extends Number & Comparable> implements Comparable<WeightedEdge> {

    /**
     * ab两个点
     */
    int a;
    int b;

    /**
     * 权重值
     */
    Weight weight;

    public WeightedEdge(int a, int b, Weight weight) {
        setA(a);
        setB(b);
        setWeight(weight);
    }

    public WeightedEdge(WeightedEdge<Weight> edge) {
        setA(edge.getA());
        setB(edge.getB());
        setWeight(edge.getWeight());
    }

    public int getOtherVertex(int v) {
        assert v == a || v == b;
        return v == a ? b : a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" +
                "a=" + a +
                ", b=" + b +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(WeightedEdge other) {
        return getWeight().compareTo(other.getWeight());
    }
}
