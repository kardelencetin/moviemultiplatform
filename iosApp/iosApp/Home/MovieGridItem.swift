//
//  MovieGridItem.swift
//  iosApp
//
//  Created by KardelenCetin on 3.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieGridItem: View {
    let movie: Movie
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            ZStack{
                AsyncImage(url: URL(string: movie.imageUrl)) {
                    image in
                    image.resizable()
                } placeholder: {
                   Color.gray
                }
                Circle()
                    .frame(width: 50, height: 50)
                    .foregroundStyle(.black.opacity(0.7))
                
                Image(systemName: "play.fill").foregroundColor(.white)
            }.frame(maxWidth: .infinity)
                .clipShape(RoundedRectangle(cornerRadius: 8))
            
            Text(movie.title)
                .font(.title3)
                .lineLimit(1)
            Text(movie.releaseDate)
                .font(.caption)
        }.frame(maxWidth: .infinity, maxHeight: 260)
    }
}
