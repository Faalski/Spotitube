package Presentation;

import Datasource.Hibernate.ItemHibernate;
import Datasource.Hibernate.LoginHibernate;
import Datasource.IitemHibernate;
import Datasource.IloginHibernate;
import Domain.Account;
import Domain.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewInventoryController extends HttpServlet {

    IloginHibernate login = new LoginHibernate();
    IitemHibernate item = new ItemHibernate();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String owner = (String)session.getAttribute("owner");
        if(checkName(owner)){
            if(request.getParameterMap().containsKey("SearchInput")){
                request.setAttribute("inventory", getItemByName(request.getParameter("SearchInput")));
            } else {
                request.setAttribute("inventory", getItems());
            }
            request.getRequestDispatcher("/ViewInventory.jsp").forward(request, response);
        } else {
            response.sendRedirect("/start.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/AddInventory");
    }

    private boolean checkName(String name) {
        boolean bool = false;
        try{
            for(Account account : login.getAccountByNameOnly(name)){
                if(account.getName().equalsIgnoreCase(name)){
                    bool = true;
                }
            }
        }catch (Exception e){
            bool = false;
        }
        return bool;
    }

    private List<Item> getItems(){
        try{
            return item.list();
        }catch (Exception e){
            return new ArrayList<Item>();
        }
    }

    private List<Item> getItemByName(String name){
        try{
            return item.getItemsByName(name);
        }catch (Exception e){
            return new ArrayList<Item>();
        }
    }
}
