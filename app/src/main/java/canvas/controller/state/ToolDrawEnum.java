package canvas.controller.state;

import java.util.Arrays;

import canvas.controller.Context;
import canvas.model.*;

public enum ToolDrawEnum implements ToolDrawState {
    LINE(1) {
        @Override
        public Element create(Point p1, Point p2, Color color) {
            return new Line(p1, p2, color);
        }
    },
    RECTANGLE(2) {
        @Override
        public Element create(Point p1, Point p2, Color color) {
            return new Rectangle(p1, p2, color);
        }
    },
    ELLIPSE(3) {
        @Override
        public Element create(Point p1, Point p2, Color color) {
            return new Ellipse(p1, p2, color);
        }
    },
    TEXT(4) {
        @Override
        public Element create(Point p1, Point p2, Color color) {
            return new Text(p1, p2, color);
        }

        @Override
        public void drag(Context ctx, Point p1, Point p2) {
            Color color = ctx.getColor();

            Element element = this.create(p1, p2, color);
            element.setText(ctx.getText());
            ctx.addElement(element);
        }
    },
    IMAGE(5) {
        @Override
        public Element create(Point p1, Point p2, Color color) {
            return new Image(p1, p2, color);
        }

        @Override
        public void drag(Context ctx, Point p1, Point p2) {
            Color color = ctx.getColor();

            Element element = this.create(p1, p2, color);
            element.setPath(ctx.getPath());
            ctx.addElement(element);
        }
    };

    private final int id;

    ToolDrawEnum(int id) {
        this.id = id;
    }

    public static ToolDrawEnum getById(int id) {
        return Arrays.stream(ToolDrawEnum.values())
                .filter(tool -> tool.id == id)
                .findFirst()
                .orElse(null);
    }

}