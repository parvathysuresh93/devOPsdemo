package com.vrms.rto.dao;
   
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import com.vrms.rto.bean.Rto;    
    
public class RtoDao {    
JdbcTemplate template;    
    
public void setTemplate(JdbcTemplate template) {    
    this.template = template;    
}    
public int save(Rto p){    
    String sql="insert into TB_RTO(name,postedat,address) values('"+p.getName()+"','"+p.getPostedAt()+"','"+p.getAddress()+"')";    
    return template.update(sql);    
}    
public int update(Rto p){    
    String sql="update TB_RTO set name='"+p.getName()+"', postedat='"+p.getPostedAt()+"',address='"+p.getAddress()+"' where id="+p.getId()+"";    
    return template.update(sql);    
}    
public int delete(int id){    
    String sql="delete from TB_RTO where id="+id+"";    
    return template.update(sql);    
}    
public Rto getRtoById(int id){    
    String sql="select * from TB_RTO where id=?";    
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Rto>(Rto.class));    
}    
public List<Rto> getRtos(){    
    return template.query("select * from TB_RTO",new RowMapper<Rto>(){    
        public Rto mapRow(ResultSet rs, int row) throws SQLException {    
            Rto e=new Rto();    
            e.setId(rs.getInt(1));    
            e.setName(rs.getString(2));    
            e.setPostedAt(rs.getString(3));    
           
            e.setAddress(rs.getString(4)); 
            return e;    
        }    
    });    
}    
}   