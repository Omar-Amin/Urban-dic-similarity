public class Vector {
    int[] vector;
    double size;

    Vector(int[] vector){
        this.vector = vector;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public int length(){
        return vector.length;
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }
}
