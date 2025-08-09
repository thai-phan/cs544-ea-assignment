package search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VectorStoreService {
    VectorStoreRepository vectorStoreRepository;

    @Autowired
    public VectorStoreService(VectorStoreRepository vectorStoreRepository) {
        this.vectorStoreRepository = vectorStoreRepository;
        fillVectorStore();
    }

    private void fillVectorStore() {
        vectorStoreRepository.cleanUpStore();
        //  Sample product catalog:
        List<String> products = List.of(
                "Profit in 2024, $45.000",
                "Profit in 2023, $35.000",
                "Profit in 2022, $12.000",
                "Profit in 2021, $18.000",
                "Profit in 2020, $41.000",
                "Profit in 2019, $57.000",
                "Profit in 2018, $33.000",
                "Profit in 2017, $18.000",
                "Profit in 2016, $77.000",
                "Profit in 2015, $89.000",
                "Profit in 2014, $76.000",
                "Profit in 2013, $92.000",
                "Profit in 2012, $45.000",
                "Profit in 2011, $35.000",
                "Profit in 2010, $12.000",
                "Profit in 2009, $18.000",
                "Profit in 2008, $41.000",
                "Profit in 2007, $57.000",
                "Profit in 2006, $33.000",
                "Profit in 2005, $18.000",
                "Profit in 2004, $77.000",
                "Profit in 2003, $89.000",
                "Profit in 2002, $76.000",
                "Profit in 2001, $89.000",
                "Profit in 2000, $76.000"
        );
        vectorStoreRepository.add(products);
    }

}
