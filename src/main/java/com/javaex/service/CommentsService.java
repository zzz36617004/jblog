package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CommentsDao;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.CommentsVo;

@Service
public class CommentsService {

		@Autowired
		private CommentsDao commentsDao;
		
		public List<CommentsVo> getcomments(CommentsVo commentvo) {
			return commentsDao.getlist(commentvo);
		}
		public CommentsVo add(CommentsVo commentvo) {
			 int cmtNo = commentsDao.addcomment(commentvo);
			 return commentsDao.selectcomment(cmtNo);
		}
		public int delete(int cmtNo) {
			
			commentsDao.delete(cmtNo);
			return cmtNo;
			}
			
		}

