document.addEventListener('DOMContentLoaded', function() {
    const searchForm = document.getElementById('searchForm');
    const searchInput = document.getElementById('searchInput');
    const bookList = document.getElementById('bookList');
    const books = bookList.querySelectorAll('li');

    searchForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const searchTerm = searchInput.value.trim().toLowerCase();

        books.forEach(function(book) {
            const title = book.querySelector('h3').textContent.toLowerCase();
            const author = book.querySelector('p:nth-of-type(1)').textContent.toLowerCase();
            const isbn = book.querySelector('p:nth-of-type(2)').textContent.toLowerCase();
            
            if (title.includes(searchTerm) || author.includes(searchTerm) || isbn.includes(searchTerm)) 
            {
                book.style.display = 'block';
            } else 
            {
                book.style.display = 'none'; 
            }
        });
    });

    books.forEach(function(book)
   {
        const borrowButton = book.querySelector('button');
        borrowButton.addEventListener('click', function()
        {
            const bookTitle = book.querySelector('h3').textContent;
            alert(`You have borrowed the book: ${bookTitle}`);
        });
    });
});
