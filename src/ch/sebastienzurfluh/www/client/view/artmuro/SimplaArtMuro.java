package ch.sebastienzurfluh.www.client.view.artmuro;

import java.util.Iterator;
import java.util.LinkedList;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class SimplaArtMuro extends ScrollPanel implements ArtMuro {
	private AbsolutePanel absolutaMuro = new AbsolutePanel();
	private AddAnimator animator;
	
	private int maxAlto;
	private int maxLargxo;
	
	public SimplaArtMuro(int largxo, int alto) {
		this.maxAlto = alto;
		this.maxLargxo = largxo;
		this.animator =  new AddAnimator(absolutaMuro, maxLargxo, maxAlto);
		
		this.setSize(largxo + "px", alto + "px");
		absolutaMuro.setSize(largxo + "px", alto + "px");
		
//		setBounce(true);
//		setScrollingEnabledX(true);
//		setScrollingEnabledY(false);
		
		setWidget(absolutaMuro);
	}
	
	/**
	 * Where the next widget will land, regarding to the x axe.
	 */
	private int left = 0;
	/**
	 * Where the next widget will land, regarding to the y axe.
	 */
	private int top = 0;
	/**
	 * The width of the last column
	 */
	private int colLargxo = 0;
	
	@Override
	public void aldoni(Afisxo afisxo) {
		
		if (afisxo.petiAlto() > maxAlto) {
//			setScrollingEnabledY(true);
		}
		
		if (top + afisxo.petiAlto() > maxAlto) {
			movePointerToNextFreeCol();
		}
		
//		new AddAnimator(absolutaMuro, maxLargxo, maxAlto).add(afisxo, left, top);
		animator.add(afisxo, left, top);
		
		// update cursor position andlargxo current column width
		colLargxo = colLargxo < afisxo.petiLargxo() ? afisxo.petiLargxo() : colLargxo;
		top += afisxo.petiAlto();
	}
	
	/**
	 * Note this will move the pointer only if the current column is non-empty. 
	 */
	private void movePointerToNextFreeCol() {
		top = 0;
		left += colLargxo;
		// the new col doesn't have a width yet
		colLargxo = 0;
	}

	@Override
	public void forigi(Afisxo afisxo) {
		absolutaMuro.remove(afisxo);
		// no repaint this is simple
	}
	
	class AddAnimator extends Animation {
		private AbsolutePanel parentPanel;
		private Widget movingWidget;
		
		private int originLeft = 0;
		private int originTop = 0;
		
		public AddAnimator(AbsolutePanel parentPanel, int width, int height) {
			// origin is bottom right corner
			this.originLeft = width;
			this.originTop = height;
			this.parentPanel = parentPanel;
		}
		
		private int destinationLeft;
		private int destinationTop;
		
		
		/**
		 * Array containing the list of animations to do in order 
		 */
		LinkedList<WorkItem> workTasks = new LinkedList<WorkItem>();
		
		public void add(IsWidget widget, int left, int top) {
			add(widget.asWidget(), left, top);
		}
		public void add(Widget widget, int left, int top) {
			workTasks.add(new WorkItem(widget, left, top));
			processAnimations();
		}

		private boolean animationRunning = false;
		private void processAnimations() {
			if(workTasks.isEmpty() || animationRunning)
				return;
			
			animationRunning = true;
			
			WorkItem animationWork = workTasks.removeFirst();
			movingWidget = animationWork.getWidget();
			destinationLeft = animationWork.getLeft();
			destinationTop = animationWork.getTop();
			
			parentPanel.add(movingWidget, originLeft, originTop);
			run(1000);
		}
		
		
		@Override
		protected void onUpdate(double progress) {
			System.out.println(progress);
			parentPanel.setWidgetPosition(movingWidget,
					(int) (originLeft + progress * (destinationLeft - originLeft)),
					(int) (originTop + progress * (destinationTop - originTop)));
		}
		
		@Override
		protected void onComplete() {
			super.onComplete();
			animationRunning = false;
			processAnimations();
		}
		
		class WorkItem {
			private Widget widget;
			private int left;
			private int top;

			public WorkItem(Widget widget, int left, int top) {
				this.widget = widget;
				this.left = left;
				this.top = top;
			}

			/**
			 * @return the widget
			 */
			public Widget getWidget() {
				return widget;
			}

			/**
			 * @return the left
			 */
			public int getLeft() {
				return left;
			}

			/**
			 * @return the top
			 */
			public int getTop() {
				return top;
			}
		}
	}
}
