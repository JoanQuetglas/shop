/**
 * 
 */
package utilitats;



/**
 * @author Josep
 *
 */
public class Element<T> {

	private T info;
	private Element<T> ElementSeguent;
	
	/**
	 * 
	 * @return
	 */

	public T getInfo() {
		return info;
	}

	public Element<T> getElementSeguent() {
		return ElementSeguent;
	}

	public void setElementSeguent(Element<T> elementSeguent) {
		ElementSeguent = elementSeguent;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "ElementSencer [info=" + info + "]";
	}

	public Element(T info, Element<T> ElementSeguent) {
		this.info = info;
		this.ElementSeguent = ElementSeguent;
	}

}
