package com.sahapwnz.tennisscoreapp.service;

import com.sahapwnz.tennisscoreapp.dao.MatchDAO;
import com.sahapwnz.tennisscoreapp.dto.MatchResponceDTO;
import com.sahapwnz.tennisscoreapp.util.MappingUtil;
import lombok.Getter;

import java.util.List;

public class MatchesPaginationService {
    private final MatchDAO matchDAO = new MatchDAO();
    private final String name;
    @Getter
    private final int pageNumber;
    private final int PAGE_SIZE;

    public MatchesPaginationService(String name, String pageParam) {
        this.name = name;
        this.pageNumber = (pageParam != null) ? Integer.parseInt(pageParam) : 1;
        PAGE_SIZE = 4;
    }

    public List<MatchResponceDTO> getListOfMatches() {
        if (name != null && !name.isEmpty()) {
            return MappingUtil.convertListMatchToMatchResponse(
                    matchDAO.findAllByPlayerName(name, pageNumber));
        } else {
            return MappingUtil.convertListMatchToMatchResponse(
                    matchDAO.findAllMatchesForPagination(pageNumber));
        }
    }
public int getTotalPageNumber(){
    return (int) Math.ceil((double) getSizeOfMatches() / PAGE_SIZE);
}
    public int getSizeOfMatches() {
        if (name != null && !name.isEmpty()) {
            return matchDAO.findAllByPlayerName(name).size();
        } else {
            return matchDAO.findAll().size();
        }
    }
}
