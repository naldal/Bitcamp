package workout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class DrCanvas extends Canvas {
	private MsPaint msPaint;

	public DrCanvas(MsPaint msPaint) {
		this.msPaint = msPaint;
		this.setBackground(new Color(255, 225, 255));
	}

	@Override
	public void paint(Graphics g) {
		//전에 그려서 ArrayList에 보관한 ShapeDTO를 하나씩 꺼내서 다시 그린다
		lagacy(g);

		// 새 도형 그리기
		// 좌표
		int x1 = Integer.parseInt(msPaint.getX1T().getText().trim());
		int y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
		int x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
		int y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
		int z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
		int z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());

		// 색
		switch (msPaint.getCombo().getSelectedIndex()) {
		case 0:
			g.setColor(new Color(255, 0, 0));
			break;
		case 1:
			g.setColor(new Color(200, 91, 2));
			break;
		case 2:
			g.setColor(new Color(255, 255, 255));
			break;
		case 3:
			g.setColor(new Color(0, 255, 0));
			break;
		case 4:
			g.setColor(new Color(0, 0, 255));
			break;
		case 5:
			g.setColor(new Color(24, 2, 176));
			break;
		case 6:
			g.setColor(new Color(255, 0, 255));
			break;
		}

		// 도형
		if (msPaint.getFill().isSelected()) { // 채워진 도형
			if (msPaint.getLine().isSelected()) {
				g.drawLine(x1, y1, x2, y2);
			} else if (msPaint.getCircle().isSelected()) {
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			} else if (msPaint.getRect().isSelected()) {
				g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			} else if (msPaint.getRoundRect().isSelected()) {
				g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
			} else if (msPaint.getPen().isSelected()) {
				g.drawLine(x1, y1, x2, y2);
			}

		} else { // 빈도형
			if (msPaint.getLine().isSelected()) {
				g.drawLine(x1, y1, x2, y2);
			} else if (msPaint.getCircle().isSelected()) {
				g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			} else if (msPaint.getRect().isSelected()) {
				g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			} else if (msPaint.getRoundRect().isSelected()) {
				g.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
			} else if (msPaint.getPen().isSelected()) {
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}

	private void lagacy(Graphics g) {
		for(ShapeDTO dto : msPaint.getList()) {
			//좌표꺼내기
			int x1 = dto.getX1();
			int y1 = dto.getY1();
			int x2 = dto.getX2();
			int y2 = dto.getY2();
			int z1 = dto.getZ1();
			int z2 = dto.getZ2();
			
			//색
			switch (dto.getColor()) {
			case 0:
				g.setColor(new Color(255, 0, 0));
				break;
			case 1:
				g.setColor(new Color(200, 91, 2));
				break;
			case 2:
				g.setColor(new Color(255, 255, 255));
				break;
			case 3:
				g.setColor(new Color(0, 255, 0));
				break;
			case 4:
				g.setColor(new Color(0, 0, 255));
				break;
			case 5:
				g.setColor(new Color(24, 2, 176));
				break;
			case 6:
				g.setColor(new Color(255, 0, 255));
				break;
			}
			
			//도형
			if (dto.isFill()) { // 채워진 도형
				if (dto.getShape()==Figure.LINE) {
					g.drawLine(x1, y1, x2, y2);
				} else if (dto.getShape()==Figure.CRLCLE) {
					g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				} else if (dto.getShape()==Figure.RCT) {
					g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				} else if (dto.getShape()==Figure.ROUNDRECT) {
					g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
				} else if (dto.getShape()==Figure.PEN) {
					g.drawLine(x1, y1, x2, y2);
				}

			} else { // 빈도형
				if (dto.getShape()==Figure.LINE) {
					g.drawLine(x1, y1, x2, y2);
				} else if (dto.getShape()==Figure.CRLCLE) {
					g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				} else if (dto.getShape()==Figure.RCT) {
					g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				} else if (dto.getShape()==Figure.ROUNDRECT) {
					g.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
				} else if (dto.getShape()==Figure.PEN) {
					g.drawLine(x1, y1, x2, y2);
				}
			}
		}		
	}
}
