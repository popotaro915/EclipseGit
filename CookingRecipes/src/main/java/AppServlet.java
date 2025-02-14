import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; //�A�m�e�[�V�����@�\
import javax.servlet.http.HttpServlet; //HttpServlet�Ȃ�
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppServlet")
public class AppServlet extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
    req.setCharacterEncoding("utf-8");
    res.setContentType("text/html;charset=utf-8");
    PrintWriter out = res.getWriter();
    
    int food_int; //元の数に人数を掛けたもの(整数)
    double food_double; //元の数に人数を掛けたもの(小数)
    int amount_int; //一人前の量×人数をしたもの(整数)
    double amount_double; //一人前の量×人数をしたもの(小数)
    /*合いびき肉125g/人*/
    food_int = 125;
    amount_int = food_int * Integer.parseInt(req.getParameter("servings"));
    String str = Integer.toString(amount_int);
    req.setAttribute("meat", str);
    /*玉ねぎ100g/人*/
    food_int = 100;
    amount_int = food_int * Integer.parseInt(req.getParameter("servings"));
    str = Integer.toString(amount_int);
    req.setAttribute("onion", str);
    /*サラダ油大さじ1固定*/
    //パン粉大さじ2/人
    food_int = 2;
    String result;
    if(food_int * Integer.parseInt(req.getParameter("servings")) >= 6) {
        //大さじが6以上になる場合は、グラム表記にする
        result = food_int * Integer.parseInt(req.getParameter("servings")) * 15 + "g"; //大さじ1=15g
    } else {
        //大さじが6未満になる場合は、大さじ表記にする
        result = "大さじ" + food_int * Integer.parseInt(req.getParameter("servings"));
    }
    req.setAttribute("breadcrumbs", result);
    //牛乳大さじ2/人
    food_int = 2;
    if(food_int * Integer.parseInt(req.getParameter("servings")) >= 6) {
        result = food_int * Integer.parseInt(req.getParameter("servings")) * 15 + "g"; //大さじ1=15g
    } else {
        result = "大さじ" + food_int * Integer.parseInt(req.getParameter("servings"));
    }
    req.setAttribute("Milk", result);
    //おろしにんにく0.25片分/人
    food_double = 0.25;
    amount_double = food_double * Integer.parseInt(req.getParameter("servings"));
    req.setAttribute("garlic", amount_double);
    //塩小さじ0.25/人
    food_double = 0.25;
    amount_double = food_double * Integer.parseInt(req.getParameter("servings"));
    //3 <= amount_double < 18かつamount_doubleが3,6,9,12,15のときは大さじだけ表示(小さじは表示しない)
    if(amount_double % 3 == 0 && amount_double >= 3 && amount_double < 18) { 
        result = "大さじ" + (int)(amount_double) / 3;
    } else if(amount_double >= 18){
        //amount_double >= 18のとき、グラム表記にする
        result = amount_double * 5 + "g"; //大さじ1=15g、大さじ1=小さじ3
    } else if(amount_double >= 3) {
        //3 <= amount_double < 18のとき、大さじと小さじで表記する
        result = "大さじ" + (int)(amount_double) / 3 + "小さじ" 
                + ((amount_double - (int)(amount_double) + (int)(amount_double) % 3));
    } else {
        //amount_double < 3のとき、小さじで表記する
        result = "小さじ" + amount_double;
    }
    req.setAttribute("solt", result);
    //砂糖小さじ0.25/人
    food_double = 0.25;
    amount_double = food_double * Integer.parseInt(req.getParameter("servings"));
    if(amount_double % 3 == 0 && amount_double >= 3 && amount_double < 18) {
        result = "大さじ" + (int)(amount_double) / 3;
    } else if(amount_double >= 18){
        result = amount_double * 5 + "g"; //大さじ1=15g、大さじ1=小さじ3
    } else if(amount_double >= 3) {
        result = "大さじ" + (int)(amount_double) / 3 + "小さじ" 
                + ((amount_double - (int)(amount_double) + (int)(amount_double) % 3));
    } else {
        result = "小さじ" + amount_double;
    }
    req.setAttribute("sugar", result);
    //胡椒1振り/人
    food_int = 1;
    amount_int = food_int * Integer.parseInt(req.getParameter("servings"));
    str = Integer.toString(amount_int);
    req.setAttribute("pepper", str);
    //ケチャップ大さじ1/人
    food_int = 1;
    if(food_int * Integer.parseInt(req.getParameter("servings")) >= 6) {
        result = food_int * Integer.parseInt(req.getParameter("servings")) * 15 + "g"; //大さじ1=15g
    } else {
        result = "大さじ" + food_int * Integer.parseInt(req.getParameter("servings"));
    }
    req.setAttribute("ketchup", result);
    //ウスターソース大さじ0.5/人
    food_double = 0.5;
    if(food_double * Integer.parseInt(req.getParameter("servings")) >= 6) {
        result = food_double * Integer.parseInt(req.getParameter("servings")) * 15 + "g"; //大さじ1=15g
    } else {
        result = "大さじ" + food_double * Integer.parseInt(req.getParameter("servings"));
    }
    req.setAttribute("WorcestershireSauce", result);
    //醤油大さじ0.3/人
    food_double = 0.3;
    if(food_double * Integer.parseInt(req.getParameter("servings")) >= 6) {
        result = food_double * Integer.parseInt(req.getParameter("servings")) * 15 + "g"; //大さじ1=15g
    } else {
        result = "大さじ" + food_double * Integer.parseInt(req.getParameter("servings"));
    }
    req.setAttribute("soySauce", result);
    out.println("</body>");
    out.println("</html>");
    
    RequestDispatcher rd = req.getRequestDispatcher("/CookingRecipe.jsp");
    rd.forward(req, res);
  }
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
    doPost(req, res);
  }
}
