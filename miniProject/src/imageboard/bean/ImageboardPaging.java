package imageboard.bean;

import lombok.Data;

@Data
public class ImageboardPaging {

	private int currentPage; //현재페이지
	private int pageBlock; //[이전][1][2][3][다음]
	private int pageSize; //1페이지당 3개씩
	private int totalA; //총글수
	private StringBuffer pagingHTML;
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		
		int totalP = (totalA+pageSize-1)/pageSize; //총 페이지수
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;;
		int endPage = startPage+pageBlock-1;
		if(endPage > totalP) {
			endPage = totalP;
		}
		 
		System.out.println("totalP : "+totalP);
		System.out.println("startPage : "+startPage);
		System.out.println("endPage : "+endPage);
		
		
		if(startPage > pageBlock) {
			//pagingHTML.append("[<a id='paging' href='imageboardList.do?pg="+(startPage-1)+"'>이전</a>]");
			pagingHTML.append("[<span id='paging' onclick='imageboardPaging("+(startPage-1)+")'>이전</span>]");		
		}
		
		for(int i=startPage; i<=endPage; i++) {
			if(i == currentPage) {
				//pagingHTML.append("[<a id='currentPaging' href='imageboardList.do?pg="+i+"'>"+i+"</a>]");
				pagingHTML.append("[<span id='currentPaging' onclick='imageboardPaging("+i+")'>"+i+"</span>]");
			} else {
				pagingHTML.append("[<span id='paging' onclick='imageboardPaging("+i+")'>"+i+"</span>]");
			}
		}
		if(endPage<totalP) {
			//pagingHTML.append("[<a id='paging' href='imageboardList.do?pg="+(endPage+1)+"'>다음</a>]");
			pagingHTML.append("[<span id='paging' onclick='imageboardPaging("+(endPage+1)+")'>이전</span>]");
		}
	}
}