
package proxy;

import lombok.Data;
import service.MemberServiceImpl;

@Data
public class Pagination implements Proxy {
	private int pageNumber, pageSize, blockSize, pageCount, rowCount, blockCount, beginRow, endRow, beginPage, endPage,
			prevBlock, nextBlock;
	boolean existPrev, existNext;

	@Override
	public void carryOut(Object o) {
		this.pageNumber = (int) o;
		this.pageSize = 5; // 한페이지의 row의 수는 5
		this.blockSize = 5; // 1block이 5page Size
		this.rowCount = MemberServiceImpl.getInstance().Count();
		this.pageCount = (rowCount % pageSize == 0) ? rowCount / pageSize : rowCount / pageSize + 1;
		this.blockCount = (pageCount % blockSize == 0) ? pageCount / blockSize : pageCount / blockSize + 1;
		this.beginRow = pageNumber * pageSize - (pageSize - 1);
		this.endRow = pageNumber * pageSize;
		this.beginPage = pageNumber - ((pageNumber - 1) % blockSize);
		this.endPage = ((beginPage + pageSize - 1) < pageCount) ? beginPage + blockSize - 1 : pageCount;
		this.prevBlock = beginPage - blockSize;
		this.nextBlock = beginPage + blockSize;
		this.existPrev = (prevBlock >= 0);
		this.existNext = (nextBlock <= pageCount);
	}
}
