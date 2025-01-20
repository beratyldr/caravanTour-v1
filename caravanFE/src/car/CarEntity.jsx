

export default function CarEntity({
    code,
    brandName,
    constructionYear,
    segment,
    capacity,
    price,
    status,

}) {
    return (
        <div className="row" key={code}>
            <div className="col">
                <div className="card">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSH0vOS2WSwAZYBlovPrFz1Jz1CqSJb_bjWdg&usqp=CAU" className="card-img-top" alt="..." />
                    <div className="card-body">
                        <h3 className="card-title">{brandName}</h3>
                        <p className="card-text"><b>Kapasite:</b>{capacity}</p>
                        <p className="card-text"><b>Fiyat:</b>{price}</p>
                    </div>
                </div>
            </div>
        </div>


    )
}