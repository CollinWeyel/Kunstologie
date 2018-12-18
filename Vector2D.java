public class Vector2D {

    public double x, y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(Vector2D v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }

    public Vector2D sub(Vector2D v) {
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }

    public Vector2D mul(double scale) {
        this.x *= scale;
        this.y *= scale;
        return this;
    }

    public Vector2D div(double scale) {
        this.x /= scale;
        this.y /= scale;
        return this;
    }

    public double dot(Vector2D v) {
        return this.x * v.x + this.y * v.y;
    }

    public double mag() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public Vector2D norm() {
        return this.div(this.mag());
    }

    public Vector2D copy() {
        return new Vector2D(this.x, this.y);
    }

}