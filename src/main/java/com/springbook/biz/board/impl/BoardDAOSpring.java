package com.springbook.biz.board.impl;import com.springbook.biz.board.BoardVo;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.jdbc.core.JdbcTemplate;import org.springframework.jdbc.core.RowMapper;import org.springframework.stereotype.Repository;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;@Repositorypublic class BoardDAOSpring {    @Autowired    public JdbcTemplate jdbcTemplate;    private final String BOARD_INSERT = "INSERT INTO BOARD(TITLE, WRITER ,CONTENT) VALUES(?,?,?)";    private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE = ?, WRITER = ?, CONTENT = ? WHERE ID = ? WHERE SEQ = ?";    private final String BOARD_DELETE = "DELETE FROM BOARD WHERE SEQ = ?";    private final String BOARD_GET    = "SELECT * FROM BOARD WHERE SEQ = ?";    private final String BOARD_LIST   = "SELECT * FROM BOARD ORDER BY SEQ DESC";    public void insertBoard(BoardVo vo) {        System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");        jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());    }    public void updateBoard(BoardVo vo) {        System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");        jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getSeq());    }    public void deleteBoard(BoardVo vo) {        System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");        jdbcTemplate.update(BOARD_DELETE, vo.getSeq());    }    public BoardVo getBoard(BoardVo vo) {        System.out.println("===> Spring JDBC로 getBoard() 기능 처리");        Object[] args = { vo.getSeq() };        return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());    }    public List<BoardVo> getBoardList(BoardVo vo) {        System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");        return jdbcTemplate.query(BOARD_GET, new BoardRowMapper());    }    static class BoardRowMapper implements RowMapper<BoardVo> {        @Override        public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {            BoardVo board = new BoardVo();            board.setSeq(rs.getInt("SEQ"));            board.setTitle(rs.getString("TITLE"));            board.setWriter(rs.getString("WRITER"));            board.setContent(rs.getString("CONTENT"));            board.setRegDate(rs.getDate("REGDATE"));            board.setCnt(rs.getInt("CNT"));            return board;        }    }}