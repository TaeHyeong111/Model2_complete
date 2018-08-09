package proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import lombok.Data;
import service.MemberServiceImpl;

@Data
public class Pagination implements Proxy {
	int pageNumber, pageSize, blockSize, rowCount, pageCount, blockCount, beginRow, endRow, beginPage, endPage,
			prevBlock, nextBlock;
	boolean existPrev, existNext;
	@Override
	public void carrayOut(Object o) {
		this.pageNumber = (int)o; //SearchCommand 에서 페이지넘버 전송
		this.pageSize = 5; // 한페이지의 row의 갯수
		this.blockSize = 5; // 한블락에 pageNumber의 갯수
		this.rowCount = MemberServiceImpl.getInstance()
				.Count(); // 총 회원의 명수
		this.pageCount = (rowCount%pageSize==0)?rowCount/pageSize : rowCount/pageSize+1; //총 페이지의 갯수
		this.blockCount = (pageCount%blockSize==0)?pageCount/blockSize:pageCount/blockSize+1; // 총 블락의 갯수
		this.beginRow = pageNumber*pageSize - (pageSize -1);
		this.endRow = pageNumber*pageSize; 
		this.beginPage = pageNumber -((pageNumber-1)%blockSize); // 5페이지중 제일 낮은페이지
		this.endPage = ((beginPage + pageSize -1)<pageCount)? // 5페이지중 제일 높은페이지
				beginPage+blockSize-1:pageCount;
		this.prevBlock = beginPage - blockSize;
		this.nextBlock = beginPage + blockSize;
		this.existPrev = (prevBlock >= 0);
		this.existNext = (nextBlock <= pageCount);
	}
}
