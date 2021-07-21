package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter{
	//컨트롤러에 진입하기전에 차단한거 
	 @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		 //세션이 있는 지 확인
		 HttpSession session= request.getSession(false);
		 if(session != null) {
			 //세션 사용하겟다
			 Object authInfo = session.getAttribute("authInfo");
			 if(authInfo !=null) {
				 return true;
			 }
		 }
		 response.sendRedirect(request.getContextPath()+"/"); //프로젝트 명을 가지고와라 
		 
		return false;
	}
	 
	 //컨트롤러에 진입후 view가 랜더링(열리기) 전에 실행 하겠다.
	 @Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	 //컨트롤러에 진입후 view까지 랜더링한 후에 실행 하겠다는 뜻
	 @Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
