#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// Class representing a point in the Cartesian coordinate system
class Point {
private:
    double x, y;
public:
    Point(double x, double y) : x(x), y(y) {}

    // Method to calculate distance between two points
    double distanceTo(const Point& other) const {
        return sqrt(pow(x - other.x, 2) + pow(y - other.y, 2));
    }
};

// Class representing a polygon
class Polygon {
private:
    vector<Point> vertices;
public:
    // Method to add a vertex to the polygon
    void addVertex(double x, double y) {
        vertices.push_back(Point(x, y));
    }

    // Method to calculate the perimeter of the polygon
    double calculatePerimeter() const {
        double perimeter = 0.0;
        int numVertices = vertices.size();
        for (int i = 0; i < numVertices; ++i) {
            perimeter += vertices[i].distanceTo(vertices[(i + 1) % numVertices]);
        }
        return perimeter;
    }
};

int main() {
    int numSides;
    cout << "Enter the number of sides of the polygon: ";
    cin >> numSides;

    Polygon polygon;
    cout << "Enter the coordinates of the vertices:" << endl;
    for (int i = 0; i < numSides; ++i) {
        double x, y;
        cin >> x >> y;
        polygon.addVertex(x, y);
    }

    double perimeter = polygon.calculatePerimeter();
    cout << "The perimeter of the polygon is: " << perimeter << endl;

    return 0;
}
