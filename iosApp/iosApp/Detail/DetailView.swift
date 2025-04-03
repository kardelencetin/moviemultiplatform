import SwiftUI
import shared

struct DetailView: View {
    let movie : Movie
    
    init(movie: Movie) {
        self.movie = movie
        
        let coloredAppearance = UINavigationBarAppearance()
        coloredAppearance.configureWithOpaqueBackground()
        coloredAppearance.backgroundColor = UIColor.black
        coloredAppearance.titleTextAttributes = [.foregroundColor: UIColor.white]
        coloredAppearance.largeTitleTextAttributes = [.foregroundColor: UIColor.white]

        UINavigationBar.appearance().standardAppearance = coloredAppearance
        UINavigationBar.appearance().scrollEdgeAppearance = coloredAppearance
        UINavigationBar.appearance().compactAppearance = coloredAppearance
        UINavigationBar.appearance().tintColor = .white
    }
    
    var body: some View {
        ScrollView {
            VStack(spacing: 0) {
                Color.clear.frame(height: 8)

                AsyncImage(url: URL(string: movie.imageUrl)) { image in
                    image.resizable().scaledToFill()
                } placeholder: {
                    ProgressView()
                }
                .frame(maxWidth: .infinity, minHeight: 300, maxHeight: 300)
                .clipped()

                VStack(alignment: .leading, spacing: 12) {
                    Text(movie.title)
                        .font(.title2)
                        .fontWeight(.bold)
                        .foregroundColor(.white)
                        .fixedSize(horizontal: false, vertical: true)
                    
                    Button(action: {}) {
                        HStack {
                            Image(systemName: "play.fill").foregroundColor(.white)
                            Text("Start watching now").foregroundColor(.white)
                        }
                    }
                    .frame(maxWidth: .infinity, maxHeight: 16)
                    .padding()
                    .background(.red)
                    .clipShape(RoundedRectangle(cornerRadius: 8))
                    
                    Text("RELEASED IN \(movie.releaseDate)".uppercased())
                        .font(.caption2)
                        .foregroundColor(.gray)
                    
                    Text(movie.description_)
                        .font(.caption)
                        .foregroundColor(.white)
                        .fixedSize(horizontal: false, vertical: true)
                }
                .padding(8)
                .background(.black)
            }
        }
        .background(.black)
        .navigationBarTitleDisplayMode(.inline)
    }
}
