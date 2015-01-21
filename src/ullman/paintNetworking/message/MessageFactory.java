package ullman.paintNetworking.message;

import ullman.paintNetworking.Canvas;

public class MessageFactory {

    private Canvas canvas;

    public MessageFactory(Canvas canvas) {

        this.canvas = canvas;
    }

    public PaintMessage getMessage(String message) {
        PaintMessage paintMessage = null;

        String[] pieces = message.split(" ");

        switch (MessageType.valueOf(pieces[0])){

            case LINE:
                paintMessage = new LineMessage(Integer.valueOf(pieces[1]), Integer.valueOf(pieces[2]), Integer.valueOf(pieces[3]),
                        Integer.valueOf(pieces[4]), Integer.valueOf(pieces[5]),Integer.valueOf(pieces[6]));
                break;

            case SHAPE:
                paintMessage = new ShapeMessage(ShapeType.valueOf(pieces[1]), Integer.valueOf(pieces[2]), Integer.valueOf(pieces[3]),
                        Integer.valueOf(pieces[4]), Integer.valueOf(pieces[5]), Integer.valueOf(pieces[6]),
                        Integer.valueOf(pieces[7]), Boolean.valueOf(pieces[8]));
                break;

            case CLEAR:
                paintMessage = new ClearMessage(canvas);
                break;

            case BUCKET_FILL:
                paintMessage = new BucketFillMessage(Integer.valueOf(pieces[1]), Integer.valueOf(pieces[2]),
                        Integer.valueOf(pieces[3]), canvas);
                break;
        }

        return paintMessage;

    }

}
