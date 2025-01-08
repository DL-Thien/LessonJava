package org.example;

import static java.lang.Math.sqrt;

class Main {
    public static void main(String[] args) {
        int ab = 10, bc = 20, ac = 100;
        int radius = 15;
        int length = 20, width = 30;
        int side = 15;

        Perimeter calPerimeter = new Perimeter();
        calPerimeter.rightTriangle(ab, bc, ac);
        calPerimeter.circle(radius);
        calPerimeter.rectangle(length, width);
        calPerimeter.equilateralTriangle(side);

        Area calArea = new Area();
        calArea.rightTriangle(ab, bc);
        calArea.circle(radius);
        calArea.rectangle(length, width);
        calArea.equilateralTriangle(side);

        /////////////////////////////////////
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        TwoSum cal = new TwoSum();
        cal.twoSum(nums, target);
    }
}


class Perimeter {
    double perimeter;

    void rightTriangle(int ab, int bc, int ac) {
        perimeter = ab + bc + ac;
        System.out.println("Chu vi cua tam giac vuong ABC: " + perimeter);
    }

    void circle(int r) {
        perimeter = 2 * 3.14 * r;
        System.out.println("Chu vi cua hinh tron: " + perimeter);
    }

    void rectangle(int length, int width) {
        perimeter = 2 * (length + width);
        System.out.println("Chu vi cua hinh chu nhat: " + perimeter);
    }

    void equilateralTriangle(int side) {
        perimeter = 3 * side;
        System.out.println("Chu vi tam giac deu:" + perimeter);
    }
}

class Area {

    double area;

    void rightTriangle(int ab, int bc) {
        area = (float) (ab * bc) / 2;
        System.out.println("Dien tich cua tam giac vuong ABC: " + area);
    }

    void circle(int r) {
        area = 2 * 3.14 * (r * r);
        System.out.println("Dien tich cua hinh tron: " + area);
    }

    void rectangle(int length, int width) {
        area = length * width;
        System.out.println("Dien tich cua hinh chu nhat: " + area);
    }

    void equilateralTriangle(int side) {
        area = (side * side) * sqrt((double) 3 / 4);
        System.out.println("Dien tich cua tam giac deu: " + area);
    }
}

class TwoSum {
    void twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    System.out.println("[" + i + ", " + j + "]");
                }
            }
        }
    }
}
