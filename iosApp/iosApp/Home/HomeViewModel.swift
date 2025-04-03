//
//  HomeViewModel.swift
//  iosApp
//
//  Created by KardelenCetin on 3.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared

@MainActor
class HomeViewModel : ObservableObject {
    private let getMoviesUseCase = GetMoviesUseCase.init()
    
    @Published private(set) var movies: [Movie] = []
    @Published private(set) var isLoading: Bool = false
    private(set) var loadFinished: Bool = false
    private var currentPage: Int = 1
    
    func loadMovies() async {
        if isLoading {
            return
        }
        do {
            let movies = try await getMoviesUseCase.invoke(page: Int32(currentPage))
            isLoading = false
            loadFinished = movies.isEmpty
            
            // pagination
            currentPage += 1
            
            self.movies = self.movies + movies
        } catch {
            isLoading = false
            loadFinished = true
            print(error.localizedDescription)
        }
    }
}
