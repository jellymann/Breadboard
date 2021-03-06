package breadboard;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Daniel
 */
public class Lamp extends Block
{
    public static final transient Color[] LAMP_COLOURS = { Color.red, Color.green, Color.blue};
    
    int color = 0;
    boolean powered = false;

    @Override
    public void render(Graphics g, int x, int y)
    {
        g.drawImage(Breadboard.lamp, x, y, powered ? LAMP_COLOURS[color] : Color.black);
    }

    @Override
    public void update()
    {
        powered = false;
        for (int i = 0; i < 4; i++)
        {
            Block b = parent.get(row, col, i);
            if (b != null && b.powerTo[(i+2)%4])
            {
                powered = true;
                break;
            }
        }
    }

    @Override
    public void activate()
    {
        color = (color+1)%LAMP_COLOURS.length;
    }

    @Override
    public int getType()
    {
        return LAMP;
    }
    
}
